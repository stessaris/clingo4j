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
package org.lorislab.clingo4j.api;

import org.bridj.Pointer;
import static org.lorislab.clingo4j.api.Clingo.LIB;
import org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_atom_undefined;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_file_included;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_global_variable;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_operation_undefined;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_other;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_runtime_error;
import static org.lorislab.clingo4j.api.c.ClingoLibrary.clingo_warning.clingo_warning_variable_unbounded;

/**
 *
 * @author andrej
 */
public enum WarningCode {
    
    OPERATION_UNDEFINED(clingo_warning_operation_undefined),
    RUNTIME_ERROR(clingo_warning_runtime_error),
    ATOM_UNDEFINED(clingo_warning_atom_undefined),
    FILE_INCLUDED(clingo_warning_file_included),
    VARIABLE_UNBOUNDED(clingo_warning_variable_unbounded),
    GLOBAL_VARIABLE(clingo_warning_global_variable),
    OTHER(clingo_warning_other);

    private clingo_warning code;

    private WarningCode(clingo_warning code) {
        this.code = code;
    }

    public clingo_warning getCode() {
        return code;
    }

    public int getValue() {
        return (int) code.value;
    }
    
    public static WarningCode createWarningCode(int value) {
        WarningCode result = null;
        WarningCode[] values = WarningCode.values();
        for (int i=0; i<values.length && result == null; i++) {
            if (values[i].getValue() == value) {
                result = values[i];
            }
        }
        return result;
    }
    
    @Override
    public String toString() {
        Pointer<Byte> tmp = LIB.clingo_warning_string(getValue());
        return tmp.getCString();
    }
    
    
}
