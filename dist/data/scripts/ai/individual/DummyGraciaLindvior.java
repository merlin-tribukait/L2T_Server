/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */

package ai.individual;

import l2server.gameserver.instancemanager.ZoneManager;
import l2server.gameserver.model.actor.L2Character;
import l2server.gameserver.model.actor.L2Npc;
import l2server.gameserver.model.actor.instance.L2PcInstance;
import l2server.gameserver.model.quest.Quest;
import l2server.util.Rnd;

/**
 * @author LasTravel
 */

public class DummyGraciaLindvior extends Quest
{
	private int _eachHours = 1;
	private int _chance = 100000;

	public DummyGraciaLindvior(int id, String name, String descr)
	{
		super(id, name, descr);

		startQuestTimer("showMovie", _eachHours * 60000, null, null, true);
	}

	@Override
	public String onAdvEvent(String event, L2Npc npc, L2PcInstance player)
	{
		if (event.equalsIgnoreCase("showMovie"))
		{
			if (Rnd.get(100000) >= _chance)
			{
				for (L2Character pls : ZoneManager.getInstance().getZoneById(11040).getCharactersInside().values())
				{
					if (pls != null && pls instanceof L2PcInstance)
					{
						((L2PcInstance) pls).showQuestMovie(1);
					}
				}
			}
		}

		return "";
	}

	public static void main(String[] args)
	{
		new DummyGraciaLindvior(-1, "DummyGraciaLindvior", "ai");
	}
}