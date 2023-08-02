package com.example.demo.controller;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.KhachHang;
import com.example.demo.model.Utility;
import com.example.demo.repository.IChiTietSanPhamRepository;
import com.example.demo.repository.IDongSanPhamRepository;
import com.example.demo.repository.IGioHangChiTietRepository;
import com.example.demo.repository.IGioHangChiTietSessionRepo;
import com.example.demo.repository.IGioHangRepository;
import com.example.demo.repository.IMauSacRepository;
import com.example.demo.repository.INhaSanXuatRepository;
import com.example.demo.repository.ISanPhamRepository;
import com.example.demo.service.IChiTietSanPhamService;
import com.example.demo.service.ILoginService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import net.bytebuddy.utility.RandomString;


@Controller

public class LoginController {

    @Autowired
    private IChiTietSanPhamRepository iChiTietSanPhamRepository;
    @Autowired
    private IChiTietSanPhamService iChiTietSanPhamService;
    @Autowired
    private ISanPhamRepository iSanPhamRepository;
    @Autowired
    private IDongSanPhamRepository iDongSanPhamRepository;
    @Autowired
    private IMauSacRepository iMauSacRepository;
    @Autowired
    private INhaSanXuatRepository iNhaSanXuatRepository;

    @Autowired
    private IGioHangChiTietRepository repository;
    @Autowired
    private IGioHangRepository gioHangRepository;
    @Autowired
    private IGioHangChiTietSessionRepo iGioHangChiTietSessionRepo;
//    @Autowired
//    KhachHang chucVuBean;


    @Autowired
    private ILoginService service;

    @Autowired
    private JavaMailSender mailSender;


    @RequestMapping("/login")
    public String showLogin() {
        return "login/login";
    }


    @GetMapping("/checkLogin")
    public String viewAll(Model model
            , @RequestParam(defaultValue = "1") int page
            , @RequestParam(required = false, name = "tenSanPham") String keyword
            , @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                          @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max) {

        Page<ChiTietSanPham> listCTSP;
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 3);
//
        listCTSP = iChiTietSanPhamService.findAll(pageable);
        if (keyword == null || keyword.isBlank()) {
            listCTSP = iChiTietSanPhamService.findAll(pageable);
        } else {
            // listCTSP = iChiTietSanPhamService.searchByTen(keyword,pageable);
            listCTSP = iChiTietSanPhamService.searchByTenAndGiaRange(keyword, min, max, pageable);
        }
//         model.addAttribute("chiTietSPDTO", chiTietSanPhamDTO);
        model.addAttribute("listChiTietSanPham", listCTSP);
        return "chiTietSP/hien-thi";

//        return "redirect:/chi-tiet-san-pham";
    }


    @PostMapping("/checkLogin")
    public String checkLogin(ModelMap modelMap,
                             @RequestParam(required = false, name = "email") String username,
                             @RequestParam(name = "matKhau") String password, Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false, name = "tenSanPham") String keyword,
                             @RequestParam(name = "min", defaultValue = "0") BigDecimal min,
                             @RequestParam(name = "max", defaultValue = "100000000") BigDecimal max) {

        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            // Xử lý khi tên đăng nhập hoặc mật khẩu trống
            return "login/login";
        }

        KhachHang user = service.findKhachHangByEmail(username);

        if (user != null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(password, user.getMatKhau())) {
                if (user.getQuyen().equals("0")) {
                    // Xử lý đăng nhập cho admin
                    // Thực hiện các thao tác đăng nhập của admin
                    if (page < 1) page = 1;
                    Pageable pageable = PageRequest.of(page - 1, 3);

                    Page<ChiTietSanPham> listCTSP;
                    if (keyword == null || keyword.isBlank()) {
                        listCTSP = iChiTietSanPhamService.findAll(pageable);
                    } else {
                        listCTSP = iChiTietSanPhamService.searchByTenAndGiaRange(keyword, min, max, pageable);
                    }
                    model.addAttribute("listChiTietSanPham", listCTSP);

                    return "chiTietSP/hien-thi";
                } else if (user.getQuyen().equals("1")) {
                    // Xử lý đăng nhập cho khách hàng
                    // Thực hiện các thao tác đăng nhập của khách hàng
                    Page<ChiTietSanPham> listCTSP;
                    if (page < 1) page = 1;
                    Pageable pageable = PageRequest.of(page - 1, 8);
                    listCTSP = iChiTietSanPhamService.findAll(pageable);
                    if (keyword == null || keyword.isBlank() & min == null & max == null) {
                        listCTSP = iChiTietSanPhamService.findAll(pageable);
                    } else {
                        listCTSP = iChiTietSanPhamService.searchByTenAndGiaRange(keyword, min, max, pageable);
                    }
                    // model.addAttribute("chiTietSPDTO", chiTietSanPhamDTO);
                    model.addAttribute("user", user);
                    model.addAttribute("listChiTietSanPham", listCTSP);
                    return "ban-hang/hien-thi";
                }
            }
        }

        // Xử lý khi tên đăng nhập hoặc mật khẩu không đúng
        model.addAttribute("ERROR", "Username or password not exist");
        return "login/login";
    }

    @RequestMapping("/logout")
    public String logOut() {
        return "login/login";

    }


    @GetMapping("/forgot_password")
    public String showForgotPasswordForm() {
        return "login/forgot";
    }

    @GetMapping("/dangki-taikhoan")
    public String formDangKi() {
        return "login/dangki";
    }


    @PostMapping("/dangki-taikhoan")
    public String dangKiTaiKhoan(@ModelAttribute("dangKi") KhachHang khachHang) {
        // Thêm khách hàng và giỏ hàng
        service.add(khachHang);

        // Chuyển hướng đến trang thành công (hoặc trang khác)
        return "login/login";
    }

    //    @PostMapping("/forgot_password")
//    public String processForgotPassword(HttpServletRequest request, Model model) throws UnsupportedEncodingException, MessagingException {
//        String email = request.getParameter("ma");
//        String token = RandomString.make(10);
//
////
//        service.updateResetPasswordToken(token, email);
//        String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
////        System.out.println(resetPasswordLink);
//        sendEmail(email,resetPasswordLink);
//
//        return "login/forgot";
//
//    }
    @PostMapping("/forgot_password")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String token = RandomString.make(10);

        // Cập nhật mã thông báo đặt lại mật khẩu trong cơ sở dữ liệu
        service.updateResetPasswordToken(token, email);

        try {
            // Tạo URL đặt lại mật khẩu
            String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;

            // Gửi email chứa liên kết đặt lại mật khẩu
            sendEmail(email, resetPasswordLink);

            // Trả về giao diện forgot thành công
            return "login/forgot";
        } catch (UnsupportedEncodingException | MessagingException e) {
            // Xử lý lỗi gửi email
            model.addAttribute("error", "Đã xảy ra lỗi trong quá trình gửi email.");
            return "login/Error";
        }
    }


    public void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("codejava.net@gmail.com", "Quen Mat Khau");

        helper.setTo(email);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + resetPasswordLink + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

//    @GetMapping("/reset_password")
//    private String resetPass()

    @GetMapping("/reset_password")
    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
        KhachHang customer = service.get(token);

        model.addAttribute("token", token);
        return "login/resetpass";
    }

    //
    @PostMapping("/reset_password")
    public String processResetPassword(@RequestParam("token") String token, @RequestParam("matKhau") String password, Model model) {
        KhachHang chucVu = service.getKhachHangByResetPassToken(token);
        if (chucVu == null) {
            model.addAttribute("message", "Invalid Token");
        } else {
            service.updatePassword(chucVu, password);
            model.addAttribute("message", "You have successfully changed your password.");
        }
        model.addAttribute("title", "Reset your password");
        return "login/login";
    }


}
