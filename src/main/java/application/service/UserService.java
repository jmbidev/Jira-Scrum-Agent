package application.service;

import application.data.entity.User;
import application.data.request.UserRequest;
import application.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @return
     */
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    /**
     *
     * @param userRequest
     */
    public User save (UserRequest userRequest) {
      return userRepository.save(new User(userRequest.getAttId(), userRequest.getName(), userRequest.getLastName()));

    }

    /**
     *
     * @param id
     * @return
     */
    public User findById(Long id) {
        return userRepository.findOne(id);
    }
}
