package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;

import service.ProdutoService;



@WebServlet(name = "ListarProdutos.do", urlPatterns = { "/ListarProdutos.do" })
public class ListarProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

	    ProdutoService produtoService = new ProdutoService();
	  
	    ArrayList<Produto> listarProdutos = null;
		 
		listarProdutos = produtoService.listarProdutos ();
			
		response.setContentType ("text/html"); 
		
		
		PrintWriter saida = response.getWriter();
	
		saida.println ("<br>  <h3> Lista de Produtos </h3> ");
		
	    saida.println (" <br>" + " " );	  
	 
		saida.println ("<html>");
		saida.println ("<body>");
		saida.println ("<table>");
					
		saida.println ("<tr>");
		
		saida.println ("<th>Codigo</th>");
		saida.println ("<th>Nome</th>");
		saida.println ("<th>Descricao</th>");
		saida.println ("<th>Valor</th>");
		saida.println ("<th>Estoque</th>");
		saida.println ("<th>Excluir</th>");
		saida.println ("<th>Alterar</th>");
		
	
		saida.println ("</tr>");
		
		

	    listarProdutos.forEach (
	    	p ->{
	    		
	    		
	    		
	    		saida.println ("<tr>");
		    	
	    		
	      		saida.println ("<td>" );
	    		
	    		saida.println(p.getCodigo());
	    		
	    		saida.println ("</td>");
	    		
	    		
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getNome());
	    		saida.println ("</td>");
	    		
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getDescricao());
	    		saida.println ("</td>");
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getValor());
	    		saida.println ("</td>");
	    		
	    		saida.println ("<td>");
	    		saida.println(p.getEstoque());
	    		saida.println ("</td>");
	    		
	    		saida.println ("<td>");
	    		saida.println("<a href= 'ExcluirProduto.do?codigo="
	    				       + p.getCodigo() + " ' > Excluir </a>");
	    		
	    		saida.println ("</td>");
	    		
	    		
	    		saida.println ("<td>");
	    		
	    		saida.println ("<a href='AlterarProduto.do?codigo="
	    				+ p.getCodigo() + "'>Alterar");
	    		
	    		saida.println ("</tr>");
	    		
	 
	    		
	    	
	    	}
	    
	    );
	    saida.println ("</table>");
	   
		saida.println ("</body>");
		
		 saida.println ("</html>");
		 


		
		
	}

}
