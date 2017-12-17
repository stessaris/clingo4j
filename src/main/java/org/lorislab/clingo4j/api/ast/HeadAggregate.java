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
import java.util.Optional;

/**
 *
 * @author andrej
 */
public class HeadAggregate {
    private AggregateFunction function;
    private List<HeadAggregateElement> elements;
    private Optional<AggregateGuard> leftGuard;
    private Optional<AggregateGuard> rightGuard;    

    public List<HeadAggregateElement> getElements() {
        return elements;
    }

    public AggregateFunction getFunction() {
        return function;
    }

    public Optional<AggregateGuard> getLeftGuard() {
        return leftGuard;
    }

    public Optional<AggregateGuard> getRightGuard() {
        return rightGuard;
    }
    
    
}
