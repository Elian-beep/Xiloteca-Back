package br.com.elian.Xiloteca.entity.dto;

import br.com.elian.Xiloteca.entity.enums.UserRole;

public record RegisterDTO(String name, String user, String password, UserRole role) {
}
