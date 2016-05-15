package am.ik.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    Optional<Member> findByEmail(@Param("email") String email);

    @Query("SELECT x FROM Member x WHERE x.memberId IN (:ids) ORDER BY x.familyName, x.givenName")
    List<Member> findByIds(@Param("ids") List<UUID> ids);
}
