package dev.handballgoalkeeper.accountinglite.repositories.abstractions;

import dev.handballgoalkeeper.accountinglite.models.AssociateTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociateTypeRepository
        extends JpaRepository<AssociateTypeModel, Long>, PagingAndSortingRepository<AssociateTypeModel, Long> {
}
