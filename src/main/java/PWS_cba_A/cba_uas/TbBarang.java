/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS_cba_A.cba_uas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "tb_barang")
@NamedQueries({
    @NamedQuery(name = "TbBarang.findAll", query = "SELECT t FROM TbBarang t"),
    @NamedQuery(name = "TbBarang.findByIdBarang", query = "SELECT t FROM TbBarang t WHERE t.idBarang = :idBarang"),
    @NamedQuery(name = "TbBarang.findByNamaBarang", query = "SELECT t FROM TbBarang t WHERE t.namaBarang = :namaBarang"),
    @NamedQuery(name = "TbBarang.findByStokBarang", query = "SELECT t FROM TbBarang t WHERE t.stokBarang = :stokBarang"),
    @NamedQuery(name = "TbBarang.findByHargaBarang", query = "SELECT t FROM TbBarang t WHERE t.hargaBarang = :hargaBarang")})
public class TbBarang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_barang")
    private String idBarang;
    @Basic(optional = false)
    @Column(name = "nama_barang")
    private String namaBarang;
    @Basic(optional = false)
    @Column(name = "stok_barang")
    private int stokBarang;
    @Basic(optional = false)
    @Column(name = "harga_barang")
    private int hargaBarang;

    public TbBarang() {
    }

    public TbBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public TbBarang(String idBarang, String namaBarang, int stokBarang, int hargaBarang) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.stokBarang = stokBarang;
        this.hargaBarang = hargaBarang;
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }

    public int getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarang != null ? idBarang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbBarang)) {
            return false;
        }
        TbBarang other = (TbBarang) object;
        if ((this.idBarang == null && other.idBarang != null) || (this.idBarang != null && !this.idBarang.equals(other.idBarang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PWS_cba_A.cba_uas.TbBarang[ idBarang=" + idBarang + " ]";
    }
    
}
