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



@WebServlet(name = "AlterarProduto.do", urlPatterns = { "/AlterarProduto.do" })
public class AlterarProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		   
		 ProdutoService produtoService = new ProdutoService();
		 
		 ArrayList<Produto> listarProdutos = null;
		 
		 listarProdutos = produtoService.listarProdutos ();
		 
			response.setContentType ("text/html");        
			
			PrintWriter saida = response.getWriter();
			
			saida.println ("<br>  <h3> Alterar  Produtos </h3> ");
			
			saida.println (" <p>&#128514;</p>");			
			
        
			  
			   	saida.println (" <br>" + " " );	  
				
			   	
				
				saida.println ("<br> Digite as alterações: <br>");   
				saida.println (" <br>" + " " );	  
				
				int codigo = Integer.parseInt(request.getParameter("codigo"));
				
				Produto produto = produtoService.consultar(codigo);
				
		
					
				saida.println ("<form action= 'AlterarProduto.do'  method = 'post'>");
				
			
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
				saida.println ("<input type=\"text\"name='valor_produto value ='"
						+ produto.getValor() +"'> <br>");
				
				saida.println (" <br>" + " " );	  
				
				
				saida.println ("Estoque: ");
				saida.println ("<input type=\"text\"name='estoque_produto value ='"
						+ produto.getEstoque() +"'> <br>");
				
				
				saida.println ("<input type='submit' value='Alterar'>");
				
				saida.println ("<input type='reset'  value='Limpar'> "); 
			

					
			 	saida.println ("<form action= 'ListarProdutos.do'  method = 'post'>");
				
				   saida.println ("<br>  <h3>Confira a Lista de Produtos </h3> ");
					
			saida.println ("<html>");
			saida.println ("<body>");
			saida.println ("<table>");
						
			saida.println ("<tr>");
  		
			saida.println ("<th>Nome</th>");
			saida.println ("<th>CPF</th>");
			saida.println ("<th>Matricula</th>");
			saida.println ("<th>Endereço</th>");
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
		    		
		    		saida.println ("<a href='AlterarProduto.do?codigo="
		    				+ p.getCodigo() + "'>Alterar");
		    		
		    		saida.println ("</tr>");
		    		
		 
		    		
		    	}
		    
		    );
		    saida.println ("</table>");
		   
			saida.println ("</body>");
			
			 saida.println ("</html>");
			 

				
				saida.println (" <p>&#128517;</p>");
				
		   	saida.println (" <br>" + " " );	   
			   	
	
	}
	
	
	
	
	
		
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int codigo = Integer.parseInt(request.getParameter("codigo_produto"));
		String descricao = request.getParameter("descricao_produto");
		String nome = request.getParameter ("nome_produto");
		double valor = Double.parseDouble(request.getParameter("valor_produto"));
		int estoque = Integer.parseInt(request.getParameter("estoque_produto"));
		

		
		Produto produto = new Produto ();
		produto.setCodigo (codigo);
		produto.setNome(nome);
		produto.setDescricao (descricao);
		produto.setValor(valor);
		produto.setEstoque(estoque);
		
		ProdutoService produtoService = new ProdutoService ();
		produtoService.alterar (produto);
		
		
		
	}

}
