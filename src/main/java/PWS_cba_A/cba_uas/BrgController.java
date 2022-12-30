/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PWS_cba_A.cba_uas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Administrator
 */

@Controller
@ResponseBody
public class BrgController {
    TbBarang data = new TbBarang();
    TbBarangJpaController actrl = new TbBarangJpaController();
    
    @RequestMapping(value = "/getName/{id}")
    public String getName(@PathVariable("id") String id){
        try {
            data = actrl.findTbBarang(id);
            return data.getNamaBarang()+"<br>"+data.getStokBarang();
        }
        catch (Exception error) {
            return "Data Tidak Ada";
        }
    }
     
}
