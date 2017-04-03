/* 
 * The MIT License
 *
 * Copyright 2017 Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package crawler.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class FilterableLinkedBlockingQueue<T> extends LinkedBlockingQueue<T> implements Filterable{
   private static DataPostProcessor dataProcessor = new DataPostProcessor();

    @Override
    public List getAllDistinctOf(Class c) {
          Class c1 = c;
        List result = new ArrayList();
        if (!this.isEmpty()) {
            result = (List) this.parallelStream().filter((el) -> el != null && el.getClass().equals(c1)).collect(Collectors.toList());
        }
        return result;
    }

    @Override
    public List getAllOf(Class c) {
        List result = getAllOf(c);
        return (List<Data>) dataProcessor.mergeDatas(result);
    }

      public FilterableLinkedBlockingQueue() {
    }

    public FilterableLinkedBlockingQueue(Collection<? extends T> c) {
        super(c);
    }

}