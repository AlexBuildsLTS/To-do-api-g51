package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;

import java.util.List;

public interface RoleService {
    // Retrieves all the roles
    List<RoleDTOView> getAll();
}
