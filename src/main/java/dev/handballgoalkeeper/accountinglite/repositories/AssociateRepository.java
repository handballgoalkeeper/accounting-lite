package dev.handballgoalkeeper.accountinglite.repositories;

import dev.handballgoalkeeper.accountinglite.models.AssociateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AssociateRepository extends JpaRepository<AssociateModel, Long>, PagingAndSortingRepository<AssociateModel, Long> {
}
