package io.aimzero.consturte.consturte.service;

import io.aimzero.consturte.consturte.domain.User;
import io.aimzero.consturte.consturte.model.UserDTO;
import io.aimzero.consturte.consturte.repos.UserRepository;
import io.aimzero.consturte.consturte.util.NotFoundException;
import io.aimzero.consturte.consturte.util.ReferencedWarning;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        final List<User> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .toList();
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setR(user.getR());
        userDTO.setRt(user.getRt() == null ? null : user.getRt().getId());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setR(userDTO.getR());
        final User rt = userDTO.getRt() == null ? null : userRepository.findById(userDTO.getRt())
                .orElseThrow(() -> new NotFoundException("rt not found"));
        user.setRt(rt);
        return user;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final User user = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final User rtUser = userRepository.findFirstByRtAndIdNot(user, user.getId());
        if (rtUser != null) {
            referencedWarning.setKey("user.user.rt.referenced");
            referencedWarning.addParam(rtUser.getId());
            return referencedWarning;
        }
        return null;
    }

}
