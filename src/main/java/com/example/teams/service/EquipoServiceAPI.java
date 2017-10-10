package com.example.teams.service;

import java.util.List;

import javax.jdo.annotations.Transactional;

import com.example.teams.entity.Equipo;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;

@Api(name = "teams", version = "v1", namespace = @ApiNamespace(ownerDomain = "service.teams.example.com", ownerName = "service.teams.example.com", packagePath = ""))
// [END echo_api_annotation]

public class EquipoServiceAPI {

	private EquipoService equipoService;

	@ApiMethod(name = "add", path = "equipo", httpMethod = ApiMethod.HttpMethod.POST)
	public Equipo addEquipo(@Named("id") String id, @Named("nombre") String nombre,
			@Named("anoFundacion") Integer anoFundacion, @Named("estrellas") Integer estrellas)
			throws NotFoundException {

		equipoService = new EquipoService();
		Equipo equipo = new Equipo(id, nombre, anoFundacion, estrellas);
		if (equipoService.addEquipo(equipo)) {
			return equipo;
		} else {
			throw new NotFoundException("Equipo no se pudo agregar.");
		}
	}

	@ApiMethod(name = "update", path = "equipo", httpMethod = ApiMethod.HttpMethod.PUT)
	public Equipo updateEquipo(Equipo e) throws NotFoundException {
		equipoService = new EquipoService();
		if (equipoService.updateEquipo(e)) {
			return e;
		} else {
			throw new NotFoundException("Equipo no existe.");
		}
	}

	@Transactional
	@ApiMethod(name = "remove", path = "equipo/{id}", httpMethod = ApiMethod.HttpMethod.DELETE)
	public void removeTeam(@Named("id") String id) throws NotFoundException {
		equipoService = new EquipoService();
		if (!equipoService.removeEquipo(id)) {
			throw new NotFoundException("Equipo no existe.");
		}
	}

	@ApiMethod(name = "getAll", path = "equipos", httpMethod = ApiMethod.HttpMethod.GET)
	public List<Equipo> getTeams() {

		equipoService = new EquipoService();
		List<Equipo> equipos = equipoService.getEquipos();

		return equipos;
	}

	@ApiMethod(name = "getById", path = "equipos/{id}", httpMethod = ApiMethod.HttpMethod.GET)
	public Equipo getEquipo(@Named("id") String id) throws NotFoundException {
		equipoService = new EquipoService();
		Equipo equipo = equipoService.getEquipoById(id);
		if (equipo != null) {
			return equipo;
		} else {
			throw new NotFoundException("Equipo no existe.");
		}
	}
}
