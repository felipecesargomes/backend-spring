package br.com.cappacitar.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cappacitar.DTO.UsuarioDTO;
import br.com.cappacitar.entity.Usuario;
import br.com.cappacitar.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioDTO> implements UserDetailsService {

	private UsuarioRepository usuarioRepository;
//	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		super(usuarioRepository, UsuarioDTO.class, Usuario.class);
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Usuario usuario = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));
		System.out.println(usuario.getPassword());
		return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles("USER").build();
	}

	@Override
	@Transactional
	public UsuarioDTO save(UsuarioDTO dto) throws Exception {
		Usuario usuario;
		ModelMapper modelMapper = new ModelMapper();
		try {
			usuario = (Usuario) modelMapper.map(dto, Usuario.class);
			String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
//			System.out.println("usuario: " + passwordEncoder);
			usuario.setPassword("{bcrypt}" + senhaCriptografada);
			usuario = (Usuario) usuarioRepository.save(usuario);
			return (UsuarioDTO) modelMapper.map(usuario, UsuarioDTO.class);
		} catch (Exception e) {
			throw new Exception("Erro ao salvar o usuário", e);
		}
	}

}