package ugtsic.sesaprn.testedesenv.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ugtsic.sesaprn.testedesenv.models.Curriculo;
import ugtsic.sesaprn.testedesenv.services.CurriculoService;
import ugtsic.sesaprn.testedesenv.services.FileStorageService;

import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/curriculo")
public class CurriculoController {
    CurriculoService curriculoService;

    FileStorageService fileStorageService;
    public CurriculoController(CurriculoService curriculoService, FileStorageService fileStorageService) {
        this.curriculoService = curriculoService;
        this.fileStorageService = fileStorageService;
    }

    private static final long MAX_FILE_SIZE = 1024 * 1024; // 1MB

    @PostMapping("/submit")
    public String submitCurriculum(@ModelAttribute @Valid Curriculo curriculo, Errors errors, @RequestParam(name = "arquivo", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response,  RedirectAttributes redirectAttributes) throws IOException{

            curriculo.setIpAddress(request.getRemoteAddr());
            curriculo.setSubmissionDateTime(LocalDateTime.now());

            System.out.println(file);

        if (file != null && !file.isEmpty()) {
            // Verificar tamanho do arquivo
            if (file.getSize() > MAX_FILE_SIZE) {
                redirectAttributes.addFlashAttribute("mensagem", "O tamanho do arquivo não pode ser maior que 1MB.");
                return "redirect:/ok";
            }

            // Verificar extensão do arquivo
            String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
            if (!isValidFileExtension(fileExtension)) {
                redirectAttributes.addFlashAttribute("mensagem", "Apenas arquivos .doc, .docx ou .pdf são permitidos.");
                return "redirect:/ok";
            }

            String fileName = file.getOriginalFilename();
            fileStorageService.save(file);
            curriculo.setArquivo(fileName);
            System.out.println(curriculo);

            curriculoService.saveCurriculum(curriculo);

            redirectAttributes.addFlashAttribute("mensagem", "Operação concluída com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Operação não foi concluída.");
        }

        return "redirect:/ok";
    }

    private boolean isValidFileExtension(String extension) {
        // Adicione ou remova as extensões permitidas conforme necessário
        return "doc".equalsIgnoreCase(extension) || "docx".equalsIgnoreCase(extension) || "pdf".equalsIgnoreCase(extension);
    }
}