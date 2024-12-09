package gfg.org.MinorProject1.Digital.Library.repository;

import gfg.org.MinorProject1.Digital.Library.model.Txn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxnRepository extends JpaRepository<Txn, Integer> {
}
