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
package discord4j.core.internal.data.stored.embed;

import discord4j.common.json.EmbedThumbnailResponse;

import java.io.Serializable;

public final class EmbedThumbnailBean implements Serializable {

    private static final long serialVersionUID = -7099407048095931694L;

    private String url;
    private String proxyUrl;
    private int height;
    private int width;

    public EmbedThumbnailBean(final EmbedThumbnailResponse response) {
        url = response.getUrl();
        proxyUrl = response.getProxyUrl();
        height = response.getHeight();
        width = response.getWidth();
    }

    public EmbedThumbnailBean() {}

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getProxyUrl() {
        return proxyUrl;
    }

    public void setProxyUrl(final String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(final int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "EmbedThumbnailBean{" +
                "url='" + url + '\'' +
                ", proxyUrl='" + proxyUrl + '\'' +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}
