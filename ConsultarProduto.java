package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;


@WebServlet(name = "ConsultarProduto.do", urlPatterns = { "/ConsultarProduto.do" })
public class ConsultarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    ProdutoService produtoService = new ProdutoService();
		
	  
	
		response.setContentType ("text/html"); 
		
		PrintWriter saida = response.getWriter();
		
		

	    int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
	    
		produtoService.consultar (codigo);
		
		Produto produto  = new Produto();
	    produto.setCodigo(codigo);
		
		saida.println ("<form action= 'ConsultarProduto.do'  method = 'post'>");
		
		saida.println ("Codigo: ");
		saida.println ("<input type=\"text\" name='codigo_produto'  value ='"
				+ produto.getCodigo() + "'> <br>");	
		
		saida.println (" <br>" + " " );	  		
		
		saida.println ("Nome: ");
		saida.println ("<input type=\"text\" name='nome_produto'   value = '"
				+ produto.getNome() + "'> <br>");
		
		saida.println (" <br>" + " " );	  
		
		saida.println ("Descricao: ");
		saida.println ("<input type=\"text\"name='descricao_produto'   value ='"
				+ produto.getDescricao() + "'> <br>");
		
		saida.println (" <br>" + " " );	  
		
		saida.println ("Valor: ");
		saida.println ("<input type=\"text\"name='valor_produto' value ='"
				+ produto.getValor() +"'> <br>");
		
		saida.println (" <br>" + " " );	  
		
		saida.println ("Estoque: ");
		saida.println ("<input type=\"text\"name='estoque_produto' value ='"
				+ produto.getEstoque() +"'> <br>");
		
		saida.println (" <br>" + " " );	  
		
		
		
		
		saida.println ("<br> Consulta realizada com sucesso!<br>");   
		
		
		
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		   int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		
		
			Produto produto  = new Produto();
		    produto.setCodigo(codigo);
		    
		    ProdutoService produtoService = new ProdutoService();
			produtoService.consultar (codigo);
			

		
	}

}
