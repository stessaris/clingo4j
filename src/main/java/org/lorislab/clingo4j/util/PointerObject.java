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
package org.lorislab.clingo4j.util;

import org.bridj.Pointer;

/**
 *
 * @author andrej
 * @param <T>
 */
public abstract class PointerObject<T> {
    
    protected final Pointer<T> pointer;

    public PointerObject(Pointer<T> pointer) {
        this.pointer = pointer;
    }

    public Pointer<T> getPointer() {
        return pointer;
    }
    
    public T getPointerValue() {
        return pointer.get();
    }
    
    public boolean isNull() {
        return pointer == null || pointer.get() == null;
    }
}