/**
 * Copyright (C) 2018-2019 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hotels.mutantswarm.exec;

import static java.util.Arrays.asList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.hotels.mutantswarm.mutate.Mutation;
import com.hotels.mutantswarm.plan.Mutant;

@RunWith(MockitoJUnitRunner.class)
public class OutcomeTest {
  
  @Mock
  private Mutant mutant;
  @Mock
  private Mutation mutation;
  @Mock
  private TestOutcome testOutcome1, testOutcome2, testOutcome3; 
  
  @Test
  public void testStateKilled(){
    List<TestOutcome> testOutcomes = asList(testOutcome1, testOutcome2, testOutcome3);
    when(testOutcome1.getState()).thenReturn(MutantState.SURVIVED);
    when(testOutcome2.getState()).thenReturn(MutantState.KILLED);
    when(testOutcome3.getState()).thenReturn(MutantState.SURVIVED);
    
    Outcome outcome = new Outcome(mutant, mutation, testOutcomes);
    assertThat(outcome.getState(), is(MutantState.KILLED));
  }
  
  @Test
  public void testStateSurvived(){
    List<TestOutcome> testOutcomes = asList(testOutcome1, testOutcome2, testOutcome3);
    when(testOutcome1.getState()).thenReturn(MutantState.SURVIVED);
    when(testOutcome2.getState()).thenReturn(MutantState.SURVIVED);
    when(testOutcome3.getState()).thenReturn(MutantState.SURVIVED);
    
    Outcome outcome = new Outcome(mutant, mutation, testOutcomes);
    assertThat(outcome.getState(), is(MutantState.SURVIVED));
  }

}
