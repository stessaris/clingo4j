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

import org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_ast_theory_operator_type;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_ast_theory_operator_type.clingo_ast_theory_operator_type_binary_left;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_ast_theory_operator_type.clingo_ast_theory_operator_type_binary_right;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_ast_theory_operator_type.clingo_ast_theory_operator_type_unary;

/**
 *
 * @author andrej
 */
public enum TheoryOperatorType {
    
    UNARY(clingo_ast_theory_operator_type_unary,"unary"),
    BINARY_LEFT(clingo_ast_theory_operator_type_binary_left,"binary, left"),
    BINARY_RIGHT(clingo_ast_theory_operator_type_binary_right,"binary, right");
             
    private clingo_ast_theory_operator_type type;
    private String string;

    private TheoryOperatorType(clingo_ast_theory_operator_type type, String string) {
        this.type = type;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public int getValue() {
        return (int) type.value;
    }

    @Override
    public String toString() {
        return string;
    }
    
    public static TheoryOperatorType valueOfInt(int value) {
        for (TheoryOperatorType t : TheoryOperatorType.values()) {
            if (t.type.value == value) {
                return t;
            }
        }
        return null;
    }
    
}
