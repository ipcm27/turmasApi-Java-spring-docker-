package com.letscode.turmasapiigor.repository;

import com.letscode.turmasapiigor.domain.Turma;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurmaRepository extends MongoRepository<Turma, String> {
}
