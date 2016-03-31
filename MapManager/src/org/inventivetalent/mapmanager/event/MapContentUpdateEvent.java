/*
 * Copyright 2015-2016 inventivetalent. All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 *
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 *
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ''AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and contributors and should not be interpreted as representing official policies,
 *  either expressed or implied, of anybody else.
 */

package org.inventivetalent.mapmanager.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.inventivetalent.mapmanager.ArrayImage;
import org.inventivetalent.mapmanager.wrapper.MapWrapper;

/**
 * Event called when the content of a {@link MapWrapper} is updated
 */
public class MapContentUpdateEvent extends Event {

	private MapWrapper mapWrapper;
	private ArrayImage content;
	private boolean    sendContent;

	public MapContentUpdateEvent(MapWrapper mapWrapper, ArrayImage content) {
		this.mapWrapper = mapWrapper;
		this.content = content;
		this.sendContent = true;
	}

	/**
	 * @return the updated {@link MapWrapper}
	 */
	public MapWrapper getMapWrapper() {
		return mapWrapper;
	}

	/**
	 * @return the {@link ArrayImage} content
	 */
	public ArrayImage getContent() {
		return content;
	}

	/**
	 * Change the updated content
	 *
	 * @param content
	 */
	public void setContent(ArrayImage content) {
		this.content = content;
	}

	/**
	 * <code>true</code> by default
	 *
	 * @return <code>true</code> if the content will be sent to the {@link org.inventivetalent.mapmanager.manager.MapManager} viewers
	 */
	public boolean isSendContent() {
		return sendContent;
	}

	/**
	 * Change if the content is sent to the viewers
	 *
	 * @param sendContent if <code>true</code>, the content will be sent; if <code>false</code>, the content will be update without sending
	 * @see #isSendContent()
	 */
	public void setSendContent(boolean sendContent) {
		this.sendContent = sendContent;
	}

	private static HandlerList handlerList = new HandlerList();

	@Override
	public HandlerList getHandlers() {
		return handlerList;
	}

	public static HandlerList getHandlerList() {
		return handlerList;
	}
}