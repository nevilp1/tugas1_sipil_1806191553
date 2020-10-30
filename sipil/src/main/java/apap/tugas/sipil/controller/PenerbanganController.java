package apap.tugas.sipil.controller;

import apap.tugas.sipil.model.PenerbanganModel;
import apap.tugas.sipil.service.PenerbanganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PenerbanganController {
    @Autowired
    PenerbanganService penerbanganService;


    @GetMapping("/penerbangan")
    private String viewPenerbangan(
            Model model
    ){
        List<PenerbanganModel> listPenerbangan = penerbanganService.getPenerbanganList();
        model.addAttribute("listPenerbangan", listPenerbangan);
        return "viewall-penerbangan";
    }

    @GetMapping("/penerbangan/tambah")
    private String tambahPenerbangan(
            Model model
    ){
        model.addAttribute("penerbangan", new PenerbanganModel());
        return "form-tambah-penerbangan";
    }

    @PostMapping("/penerbangan/tambah")
    private String tambahPenerbanganSubmit(
            @ModelAttribute PenerbanganModel penerbangan, Model model
    ){
        penerbanganService.addPenerbangan(penerbangan);
        model.addAttribute("penerbangan", penerbangan);
        return "tambah-penerbangan";
    }
}
