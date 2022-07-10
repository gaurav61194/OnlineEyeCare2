package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;

import com.onlineeyecare.dto.Spectacles;

public interface ISpectaclesService {


	Spectacles addSpectacles(Spectacles spectacles);

	Spectacles updateSpectacles(Spectacles spectacles);

	Spectacles deleteSpectacles(Integer spectaclesId);

	Optional<Spectacles> viewSpectacles(Integer spectaclesId);

	List<Spectacles> viewSpectaclesList();
}
