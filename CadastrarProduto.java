package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProdutoService;
import model.Produto;


@WebServlet(name = "CadastrarProduto.do", urlPatterns = { "/CadastrarProduto.do" })
public class CadastrarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CadastrarProduto() {
        super();
      
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        // recebendo os dados do usuário
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String descricao = request.getParameter("descricao_produto");
		String nome = request.getParameter ("nome_produto");
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		
		//Instanciar um objeto do tipo produto
		Produto produto = new Produto ();
		produto.setCodigo (codigo);
		produto.setNome(nome);
		produto.setDescricao (descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		
		
		//Envia o objeto para a service
		
		ProdutoService produtoService = new ProdutoService ();
		produtoService.cadastrar(produto);
		
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
				saida.println ("<br> Cadastro realizado com sucesso!<br>");
		
		saida.println ( "<p>&#128512;</p>");
		
	}

		
		
	}


