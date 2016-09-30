/**
 *
 * Copyright (c) 2006-2016, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.runtime.core.internal.field.predicate.chars;

import com.speedment.common.tuple.Tuple2;
import com.speedment.runtime.core.field.predicate.Inclusion;
import com.speedment.runtime.core.field.predicate.PredicateType;
import com.speedment.runtime.core.field.trait.HasCharValue;
import com.speedment.runtime.core.internal.field.predicate.AbstractFieldPredicate;
import com.speedment.runtime.core.internal.field.predicate.BetweenPredicate;
import javax.annotation.Generated;
import static java.util.Objects.requireNonNull;

/**
 * A predicate that evaluates if a value is between two chars.
 * 
 * @param <ENTITY> entity type
 * @param <D>      database type
 * 
 * @author Emil Forslund
 * @since  3.0.0
 */
@Generated(value = "Speedment")
public final class CharBetweenPredicate<ENTITY, D> extends AbstractFieldPredicate<ENTITY, Character, HasCharValue<ENTITY, D>> implements BetweenPredicate, Tuple2<Character, Character> {
    
    private final char start;
    private final char end;
    private final Inclusion inclusion;
    
    public CharBetweenPredicate(HasCharValue<ENTITY, D> field, char start, char end, Inclusion inclusion) {
        super(PredicateType.BETWEEN, field, entity -> {
            final char fieldValue = field.getAsChar(entity);
            
            switch (inclusion) {
                case START_EXCLUSIVE_END_EXCLUSIVE :
                    return (start < fieldValue && end > fieldValue);
                
                case START_EXCLUSIVE_END_INCLUSIVE :
                    return (start < fieldValue && end >= fieldValue);
                
                case START_INCLUSIVE_END_EXCLUSIVE :
                    return (start <= fieldValue && end > fieldValue);
                
                case START_INCLUSIVE_END_INCLUSIVE :
                    return (start <= fieldValue && end >= fieldValue);
                
                default : throw new IllegalStateException("Inclusion unknown: " + inclusion);
            }
        });
        
        this.start     = start;
        this.end       = end;
        this.inclusion = requireNonNull(inclusion);
    }
    
    @Override
    public Character get0() {
        return start;
    }
    
    @Override
    public Character get1() {
        return end;
    }
    
    @Override
    public Inclusion getInclusion() {
        return inclusion;
    }
}