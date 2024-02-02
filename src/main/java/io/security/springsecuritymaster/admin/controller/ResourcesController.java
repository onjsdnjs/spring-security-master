package io.security.springsecuritymaster.admin.controller;

import io.security.springsecuritymaster.admin.repository.RoleRepository;
import io.security.springsecuritymaster.admin.service.ResourcesService;
import io.security.springsecuritymaster.admin.service.RoleService;
import io.security.springsecuritymaster.domain.dto.ResourcesDto;
import io.security.springsecuritymaster.domain.entity.Resources;
import io.security.springsecuritymaster.domain.entity.Role;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class ResourcesController {

	private final ResourcesService resourcesService;
	private final RoleRepository roleRepository;
	private final RoleService roleService;

	@GetMapping(value="/admin/resources")
	public String getResources(Model model) {
		List<Resources> resources = resourcesService.getResources();
		model.addAttribute("resources", resources);

		return "admin/resources";
	}

	@PostMapping(value="/admin/resources")
	public String createResources(ResourcesDto resourcesDto) {
		ModelMapper modelMapper = new ModelMapper();
		Role role = roleRepository.findByRoleName(resourcesDto.getRoleName());
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		Resources resources = modelMapper.map(resourcesDto, Resources.class);
		resources.setRoleSet(roles);

		resourcesService.createResources(resources);

		return "redirect:/admin/resources";
	}

	@GetMapping(value="/admin/resources/register")
	public String resourcesRegister(Model model) {

		List<Role> roleList = roleService.getRoles();
		model.addAttribute("roleList", roleList);
		List<String> myRoles = new ArrayList<>();
		model.addAttribute("myRoles", myRoles);
		ResourcesDto resources = new ResourcesDto();
		Set<Role> roleSet = new HashSet<>();
		roleSet.add(new Role());
		resources.setRoleSet(roleSet);
		model.addAttribute("resources", resources);

		return "admin/resourcesdetails";
	}

	@GetMapping(value="/admin/resources/{id}")
	public String resourceDetails(@PathVariable String id, Model model) {

		List<Role> roleList = roleService.getRoles();
		model.addAttribute("roleList", roleList);
		Resources resources = resourcesService.getResources(Long.parseLong(id));
		List<String> myRoles = resources.getRoleSet().stream().map(role -> role.getRoleName()).toList();
		model.addAttribute("myRoles", myRoles);
		ModelMapper modelMapper = new ModelMapper();
		ResourcesDto resourcesDto = modelMapper.map(resources, ResourcesDto.class);
		model.addAttribute("resources", resourcesDto);

		return "admin/resourcesdetails";
	}

	@GetMapping(value="/admin/resources/delete/{id}")
	public String removeResources(@PathVariable String id) throws Exception {

		resourcesService.deleteResources(Long.parseLong(id));

		return "redirect:/admin/resources";
	}
}
