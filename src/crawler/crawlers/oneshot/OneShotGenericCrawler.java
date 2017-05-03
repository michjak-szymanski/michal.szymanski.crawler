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
package crawler.crawlers.oneshot;

import crawler.configuration.CrawlerParams;
import crawler.configuration.CrawlerConfiguration;
import crawler.crawlers.GenericCrawler;
import crawler.data.ImageSource;
import crawler.data.Sentence;

import crawler.scrapping.filters.Filter;
import crawler.scrapping.SearchEngine;
import crawler.scrapping.collectors.ImageCollector;
import crawler.scrapping.collectors.SentenceCollector;
import java.util.Collection;


/**
 *
 * @author Michał Szymański, kontakt: michal.szymanski.aajar@gmail.com
 */
public class OneShotGenericCrawler extends OneShotCrawler implements GenericCrawler {

    @Override
    public void appendFilters(SearchEngine se, CrawlerConfiguration conf) {
        se.addCollector(new SentenceCollector((String[]) conf.get(CrawlerParams.SENTENCES)));
        se.addCollector(new ImageCollector());
    }

    @Override
    public Collection getFoundImages() {
        return super.getResults().getGroup(ImageSource.class);
    }

    @Override
    public Collection getFoundSentences() {
        return super.getResults().getGroup(Sentence.class);
    }

    @Override
    public void addImagesFilter(Filter<ImageSource> f) {
    }

    @Override
    public void addSentencesFilter(Filter<Sentence> f) {
    }

}
