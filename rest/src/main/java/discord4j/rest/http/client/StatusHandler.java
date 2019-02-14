/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J. If not, see <http://www.gnu.org/licenses/>.
 */

package discord4j.rest.http.client;

import io.netty.handler.codec.http.HttpResponseStatus;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufMono;
import reactor.netty.http.client.HttpClientResponse;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

class StatusHandler {

    private final BiPredicate<ClientRequest, HttpResponseStatus> predicate;
    private final BiFunction<HttpClientResponse, ByteBufMono, Mono<? extends Throwable>> exceptionFunction;

    public StatusHandler(BiPredicate<ClientRequest, HttpResponseStatus> predicate,
                          BiFunction<HttpClientResponse, ByteBufMono, Mono<? extends Throwable>> exceptionFunction) {
        this.predicate = predicate;
        this.exceptionFunction = exceptionFunction;
    }

    public boolean test(ClientRequest request, HttpResponseStatus status) {
        return predicate.test(request, status);
    }

    public Mono<? extends Throwable> apply(HttpClientResponse response, ByteBufMono content) {
        return exceptionFunction.apply(response, content);
    }
}
