package com.example.demo.repository;

import com.example.demo.model.ChiTietSanPham;
import com.example.demo.model.GioHang;
import com.example.demo.model.GioHangChiTiet;
import com.example.demo.model.GioHangChiTietId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

@Transactional
@Repository
public class GioHangChiTietSessionRepo implements IGioHangChiTietSessionRepo {
    @PersistenceContext
    private EntityManager entityManager;
    private PlatformTransactionManager transactionManager;

    @Autowired
    public GioHangChiTietSessionRepo(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void addToCart(GioHang gioHang, ChiTietSanPham chiTietSanPham) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            EntityManager em = entityManager.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();

            GioHangChiTiet gioHangChiTiet = em.find(GioHangChiTiet.class, new GioHangChiTietId(gioHang, chiTietSanPham));
            if (gioHangChiTiet != null) {
                // Sản phẩm đã tồn tại trong giỏ hàng, tăng số lượng lên
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
                Integer soLuongMoi = gioHangChiTiet.getSoLuong();
                BigDecimal giaBanDau = chiTietSanPham.getGiaBan();
                BigDecimal giaUpdate = giaBanDau.multiply(new BigDecimal(soLuongMoi));
                gioHangChiTiet.setDonGia(giaUpdate);
                Integer soLuongSanPham = chiTietSanPham.getSoLuongTon();
                if (soLuongSanPham > 0) {
                    Integer soLuongHienTaiSanPham = soLuongSanPham - 1;
                    chiTietSanPham.setSoLuongTon(soLuongHienTaiSanPham);
                    // Cập nhật chiTietSanPham trong cơ sở dữ liệu (nếu cần)
                    em.merge(chiTietSanPham);
                }
            } else {
                // Sản phẩm chưa tồn tại trong giỏ hàng, tạo mới đối tượng GioHangChiTiet với số lượng là 1
                gioHangChiTiet = new GioHangChiTiet();
                gioHangChiTiet.setIdGioHang(em.merge(gioHang));
                gioHangChiTiet.setIdChiTietSanPham(em.merge(chiTietSanPham));
                gioHangChiTiet.setSoLuong(1);
                gioHangChiTiet.setDonGia(chiTietSanPham.getGiaBan());
                em.persist(gioHangChiTiet);
                // Giảm số lượng trong chiTietSanPham
                Integer soLuongSanPham = chiTietSanPham.getSoLuongTon();
                if (soLuongSanPham > 0) {
                    Integer soLuongHienTaiSanPham = soLuongSanPham - 1;
                    chiTietSanPham.setSoLuongTon(soLuongHienTaiSanPham);
                    // Cập nhật chiTietSanPham trong cơ sở dữ liệu (nếu cần)
                    em.merge(chiTietSanPham);
                }
            }

            em.getTransaction().commit();
            em.close();
            return null;
        });
    }

    public void truSanPham(GioHang gioHang, ChiTietSanPham chiTietSanPham) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            EntityManager em = entityManager.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();

            GioHangChiTiet gioHangChiTiet = em.find(GioHangChiTiet.class, new GioHangChiTietId(gioHang, chiTietSanPham));
            if (gioHangChiTiet.getSoLuong() == 1) {
                em.remove(gioHangChiTiet);
            } else {
                // Sản phẩm đã tồn tại trong giỏ hàng, tăng số lượng lên
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() - 1);
                Integer soLuongMoi = gioHangChiTiet.getSoLuong();
                BigDecimal giaBanDau = chiTietSanPham.getGiaBan();
                BigDecimal giaUpdate = giaBanDau.multiply(new BigDecimal(soLuongMoi));
                gioHangChiTiet.setDonGia(giaUpdate);
                Integer soLuongSanPham = chiTietSanPham.getSoLuongTon();
                if (soLuongSanPham > 0) {
                    Integer soLuongHienTaiSanPham = soLuongSanPham + 1;
                    chiTietSanPham.setSoLuongTon(soLuongHienTaiSanPham);
                    // Cập nhật chiTietSanPham trong cơ sở dữ liệu (nếu cần)
                    em.merge(chiTietSanPham);
                }

            }
            em.getTransaction().commit();
            em.close();
            return null;
        });
    }

    public void xoaSanPham(GioHang gioHang, ChiTietSanPham chiTietSanPham) {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(status -> {
            EntityManager em = entityManager.getEntityManagerFactory().createEntityManager();
            GioHangChiTiet gioHangChiTiet = em.find(GioHangChiTiet.class, new GioHangChiTietId(gioHang, chiTietSanPham));
            em.getTransaction().begin();
            Integer soLuongSanPham = chiTietSanPham.getSoLuongTon();
            Integer soLuongSanPhamTrongGio = gioHangChiTiet.getSoLuong();
            Integer soLuongHienTaiSanPham = soLuongSanPham + soLuongSanPhamTrongGio;
            chiTietSanPham.setSoLuongTon(soLuongHienTaiSanPham);
            // Cập nhật chiTietSanPham trong cơ sở dữ liệu (nếu cần)
            em.merge(chiTietSanPham);
            em.remove(gioHangChiTiet);
            em.getTransaction().commit();
            em.close();
            return null;
        });
    }
}
