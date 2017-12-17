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

import java.util.List;
import org.bridj.Pointer;

/**
 *
 * @author andrej
 */
public final class ClingoUtil {

    private ClingoUtil() {
    }
    
    public static int arraySize(List data) {
        if (data != null) {
            return data.size();
        }
        return 0;
    }
    
    public interface Convertor<T, E> {

        public T convert(E object);

    }    

    public static <T, E> Pointer<T> createArray(List<E> data, Class<T> clazz, Convertor<T, E> convertor) {
        Pointer<T> result = null;
        if (data != null && !data.isEmpty()) {
            result = Pointer.allocateArray(clazz, data.size());
            Pointer<T> iter = result;
            for (E item : data) {
                iter.set(convertor.convert(item));
                iter = iter.next();
            }
        }
        return result;
    }

    public static Pointer<Pointer<Byte>> createListArray(List<String> data) {
        Pointer<Pointer<Byte>> result = null;
        if (data != null && !data.isEmpty()) {
            result = Pointer.pointerToCStrings(data.toArray(new String[data.size()]));
        }
        return result;
    }    
}