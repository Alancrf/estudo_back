package curso.api.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController //Arquitetura Rest
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Serviço Restful
	//Consulta de usuários cadastrados (pelo id)
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity <Usuario> init(@PathVariable (value = "id") Long id ) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity(usuario.get(),HttpStatus.OK);
		
	}
	
	//Serviço Restful
	//Cadastro de usuários
	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
		
	}
	//Serviço Restful
	//Atualização de usuários
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
		
	}
	
	//Serviço Restful
	//Delete de usuários
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public String delete (@PathVariable("id") Long id) {
		
		usuarioRepository.deleteById(id);
		
		return "Ok, usuário deletado com sucesso";
		
	}
	
	
/*	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity recebeParametro(@RequestParam (value = "nome", defaultValue = "Alan nome padrão") String nome) {
		
		System.out.println("Parametro sendo recebido "+ nome);
		return new ResponseEntity("Recebendo Parametro: Seu nome é: "+nome, HttpStatus.OK);
	}
*/	
}
