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

import java.util.Optional;
import org.lorislab.clingo4j.api.Location;

/**
 *
 * @author andrej
 */
public class TheoryAtomDefinition {
    private Location location;
    private TheoryAtomDefinitionType type;
    private String name;
    private int arity;
    private String elements;
    private Optional<TheoryGuardDefinition> guard;    

    public int getArity() {
        return arity;
    }

    public String getElements() {
        return elements;
    }

    public Optional<TheoryGuardDefinition> getGuard() {
        return guard;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public TheoryAtomDefinitionType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("&").append(name).append("/").append(arity).append(" : ").append(elements);
        if (guard.isPresent()) {
            sb.append(", ").append(guard.get());
        }
        sb.append(", ").append(type);
        return sb.toString();
    }
    
}
