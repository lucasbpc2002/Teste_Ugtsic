package ugtsic.sesaprn.testedesenv.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import ugtsic.sesaprn.testedesenv.models.Curriculo;
import ugtsic.sesaprn.testedesenv.services.CurriculoService;

import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/curriculo")
public class CurriculoController {
    CurriculoService curriculoService;

        public CurriculoController(CurriculoService curriculoService){
        this.curriculoService = curriculoService;
    }

    @PostMapping("/submit")
    public String submitCurriculum(@ModelAttribute @Valid Curriculo curriculo, HttpServletRequest request, HttpServletResponse response) {
        curriculo.setIpAddress(request.getRemoteAddr());
        curriculo.setSubmissionDateTime(LocalDateTime.now());

        System.out.println(curriculo);
        curriculoService.saveCurriculum(curriculo);

        return "submission-success";
    }

}