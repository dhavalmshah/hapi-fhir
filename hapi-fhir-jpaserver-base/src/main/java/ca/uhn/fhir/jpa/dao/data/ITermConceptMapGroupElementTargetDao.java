package ca.uhn.fhir.jpa.dao.data;

import ca.uhn.fhir.jpa.entity.TermConceptMapGroupElementTarget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/*
 * #%L
 * HAPI FHIR JPA Server
 * %%
 * Copyright (C) 2014 - 2018 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

public interface ITermConceptMapGroupElementTargetDao extends JpaRepository<TermConceptMapGroupElementTarget, Long> {
	@Query("SELECT t FROM TermConceptMapGroupElementTarget t " +
		"WHERE t.myConceptMapGroupElement.myConceptMapGroup.mySourceUrl = :source_code_system " +
		"AND t.myConceptMapGroupElement.myConceptMapGroup.myTargetUrl = :target_code_system " +
		"AND t.myConceptMapGroupElement.mySourceCode = :source_code")
	List<TermConceptMapGroupElementTarget> findTargetsByCodeSystemsAndSourceCode(
		@Param("source_code_system") String theSourceCodeSystem,
		@Param("target_code_system") String theTargetCodeSystem,
		@Param("source_code") String theSourceCode);
}
