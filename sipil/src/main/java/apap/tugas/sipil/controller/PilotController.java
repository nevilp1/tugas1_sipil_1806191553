package apap.tugas.sipil.controller;

import apap.tugas.sipil.model.AkademiModel;
import apap.tugas.sipil.model.MaskapaiModel;
import apap.tugas.sipil.model.PilotModel;
import apap.tugas.sipil.service.AkademiService;
import apap.tugas.sipil.service.MaskapaiService;
import apap.tugas.sipil.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PilotController {
    @Qualifier("pilotServiceImpl")
    @Autowired
    private PilotService pilotService;

    @Autowired
    private MaskapaiService maskapaiService;

    @Autowired
    private AkademiService akademiService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/pilot")
    private String viewPilot(Model model){
        List<PilotModel> listPilot = pilotService.getPilotList();
        model.addAttribute("listPilot", listPilot);
        return "viewall-pilot";
    }
    @GetMapping("/pilot/tambah")
    private String formAddPilot(Model model){

        List<MaskapaiModel> listMaskapai = maskapaiService.getListMaskapai();
        List<AkademiModel> listAkademi = akademiService.getAkademiList();
        String nip = "123123";
        model.addAttribute("nip",nip);
        model.addAttribute("pilot", new PilotModel());
        model.addAttribute("maskapai", new MaskapaiModel());
        model.addAttribute("akademi", new AkademiModel());
        model.addAttribute("listMaskapai", listMaskapai);
        model.addAttribute("listAkademi", listAkademi);

        return "form-tambah-pilot";
    }

    @PostMapping("/pilot/tambah")
    private String tambahPilot(
            @ModelAttribute PilotModel pilot, Model model){

        String nip = pilotService.generateID(pilot);
        pilot.setNip(nip);
        pilotService.addPilot(pilot);
        System.out.println(nip);
        model.addAttribute("nip",nip);
        model.addAttribute("idPilot",pilot.getId());
        return "tambah-pilot";
    }
    @GetMapping("/pilot/{nip}")
    private String viewPilot(
            @PathVariable String nip,
            Model model
    ){
        model.addAttribute("nip",nip);
        PilotModel pilot = pilotService.getPilotByNip(nip);
        model.addAttribute("pilot",pilot);
        return "lihat-pilot";
    }

    @GetMapping("/pilot/ubah/{nipPilot}")
    private String changePilot(
            @PathVariable String nipPilot,
            Model model
    ){
        model.addAttribute("nip", nipPilot);
        PilotModel pilot = pilotService.getPilotByNip(nipPilot);
        model.addAttribute("listMaskapai",maskapaiService.getListMaskapai());
        model.addAttribute("listAkademi",akademiService.getAkademiList());
        model.addAttribute("pilot",pilot);
        return "change-pilot";
    }

    @PostMapping("/pilot/ubah/{nipPilot}")
    private String changePilotSubmit(
            @ModelAttribute PilotModel pilot, Model model
    ){
        pilotService.updatePilot(pilot);
        model.addAttribute("nip", pilot.getNip());

        return "change-pilot-submit";
    }
    @GetMapping("/pilot/delete/{nipPilot}")
    private String deletePilot(
            @PathVariable String nipPilot, Model model
    ){
        PilotModel pilot = pilotService.getPilotByNip(nipPilot);
        model.addAttribute("nip", nipPilot);
        pilotService.deletePilot(pilot);

        return "delete-pilot";

    }

}
