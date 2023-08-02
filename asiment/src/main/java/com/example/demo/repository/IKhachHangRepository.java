package com.example.demo.repository;

import com.example.demo.DTO.KhachHangDTO;
import com.example.demo.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IKhachHangRepository extends JpaRepository<KhachHang, String> {
    @Override
    List<KhachHang> findAll();

//    @Query("select new com.example.demo.DTO.KhachHangDTO(e.ten,c.soLuong,d.giaBan*c.soLuong) from KhachHang a \n" +
//            "join GioHang b on a.id=b.idkh\n" +
//            "join GioHangChiTiet c on b.id=c.gioHangChiTietId.idGioHang\n" +
//            "join ChiTietSanPham d on c.gioHangChiTietId.idChiTietSanPham=d.id\n" +
//            "join SanPham e on e.id=d.idSP where a.id= :idkh")
//    KhachHangDTO findKhachHangById(@Param("idkh") String idkh);
}
