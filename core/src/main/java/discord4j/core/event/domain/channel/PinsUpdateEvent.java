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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.core.event.domain.channel;

import discord4j.core.DiscordClient;
import discord4j.core.object.entity.MessageChannel;
import discord4j.core.object.util.Snowflake;
import reactor.core.publisher.Mono;
import reactor.util.annotation.Nullable;

import java.time.Instant;
import java.util.Optional;

/**
 * Dispatched when a message is pinned or unpinned in a message channel.
 *
 * @see <a href="https://discordapp.com/developers/docs/topics/gateway#channel-pins-update">Channel Pins Update</a>
 */
public class PinsUpdateEvent extends ChannelEvent {

    private final long channelId;
    private final Instant lastPinTimestamp;

    public PinsUpdateEvent(DiscordClient client, long channelId, @Nullable Instant lastPinTimestamp) {
        super(client);
        this.channelId = channelId;
        this.lastPinTimestamp = lastPinTimestamp;
    }

    public Snowflake getChannelId() {
        return Snowflake.of(channelId);
    }

    public Mono<MessageChannel> getChannel() {
        return getClient().getChannelById(getChannelId()).cast(MessageChannel.class);
    }

    public Optional<Instant> getLastPinTimestamp() {
        return Optional.ofNullable(lastPinTimestamp);
    }

    @Override
    public String toString() {
        return "PinsUpdateEvent{" +
                "channelId=" + channelId +
                ", lastPinTimestamp=" + lastPinTimestamp +
                '}';
    }
}
