/*
 * Copyright 2017 andrej.
 *
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
 */
package org.lorislab.clingo4j.api.ast;

import java.util.List;
import org.lorislab.clingo4j.api.ast.Statement.StatementData;
import org.lorislab.clingo4j.c.api.clingo_ast_statement;
import org.lorislab.clingo4j.util.ClingoUtil;

/**
 *
 * @author andrej
 */
public class TheoryDefinition implements StatementData {

    private String name;
    private List<TheoryTermDefinition> terms;
    private List<TheoryAtomDefinition> atoms;

    public List<TheoryAtomDefinition> getAtoms() {
        return atoms;
    }

    public String getName() {
        return name;
    }

    public List<TheoryTermDefinition> getTerms() {
        return terms;
    }

    @Override
    public clingo_ast_statement createStatment() {
        return ASTToC.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#theory ").append(name).append(" {\n");
        boolean comma = false;
        if (terms != null) {
            for (TheoryTermDefinition term : terms) {
                if (comma) {
                    sb.append(";\n");
                } else {
                    comma = true;
                }
                sb.append("  ").append(term.getName()).append(" {\n");
                sb.append(ClingoUtil.print(term.getOperators(), "    ", ";\n", "\n", true)).append("  }");
            }
        }

        if (atoms != null) {
            for (TheoryAtomDefinition atom : atoms) {
                if (comma) {
                    sb.append(";\n");
                } else {
                    comma = true;
                }
                sb.append("  ").append(atom);
            }
        }

        if (comma) {
            sb.append("\n");
        }
        sb.append("}.");
        return sb.toString();
    }

}
