
package com.smartCloth.repository;

import com.smartCloth.model.ManagerModel;
import com.smartCloth.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface ManagerRepository extends JpaRepository<ManagerModel, Long> {
    ManagerModel findManagerModelByName(String name);

}
