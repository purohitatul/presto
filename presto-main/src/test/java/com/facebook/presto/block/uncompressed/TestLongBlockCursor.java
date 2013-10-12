/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.block.uncompressed;

import com.facebook.presto.block.AbstractTestBlockCursor;
import com.facebook.presto.block.Block;
import com.facebook.presto.tuple.TupleInfo;
import org.testng.annotations.Test;

import static com.facebook.presto.block.BlockAssertions.createLongsBlock;
import static io.airlift.testing.Assertions.assertInstanceOf;
import static org.testng.Assert.assertEquals;

public class TestLongBlockCursor
        extends AbstractTestBlockCursor
{
    @Override
    protected Block createExpectedValues()
    {
        return createLongsBlock(1111L, 1111L, 1111L, 2222L, 2222L, 2222L, 2222L, 2222L, 3333L, 3333L, 4444L);
    }

    @Test
    public void testCursorType()
    {
        assertInstanceOf(createExpectedValues().cursor(), FixedWidthBlockCursor.class);
        assertEquals(createExpectedValues().cursor().getTupleInfo(), TupleInfo.SINGLE_LONG);
    }
}