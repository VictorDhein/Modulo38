package Inventario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarProdutos());
        return "produtos";  // nome do arquivo HTML, sem a extensão .html
    }

    @PostMapping("/produtos/salvar")
    public String salvarProduto(Produto produto) {
        produtoService.salvarProduto(produto);
        return "redirect:/produtos";  // Após salvar, redireciona para a lista de produtos
    }

    @GetMapping("/produtos/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return "redirect:/produtos";  // Após excluir, redireciona para a lista de produtos
    }
}
