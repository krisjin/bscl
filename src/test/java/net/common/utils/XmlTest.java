package net.common.utils;

import net.common.utils.config.xml.client.Group;
import net.common.utils.config.xml.client.ServerElement;
import net.common.utils.config.xml.client.ServiceGroup;
import net.common.utils.config.xml.server.Server;
import net.common.utils.config.xml.server.Servers;
import net.common.utils.xml.JAXBUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/6/30
 * Time: 17:44
 */
public class XmlTest {

    public static void main(String[] args) {

        Servers servers = JAXBUtil.unmarshal(Servers.class, "redis-servers.xml");

        Map<String, Server> map = servers.getServers();
        Set<Map.Entry<String, Server>> entrySet = map.entrySet();
        for (Map.Entry<String, Server> entry : entrySet) {
            String name = entry.getKey();
            Server server = entry.getValue();
            System.out.println(name + server);
        }


        ServiceGroup serviceGroup = JAXBUtil.unmarshal(ServiceGroup.class, "redis-client.xml");

        Map<String, Group> groupMap = serviceGroup.getGroups();

        Set<Map.Entry<String, Group>> groupSet = groupMap.entrySet();

        for (Map.Entry<String, Group> entry : groupSet) {

            System.out.println(entry.getKey());
            Group group = entry.getValue();
            Group.ServerList serverList = group.getServerList();

            List<ServerElement> serverElements = serverList.getServerElements();

            for (ServerElement se : serverElements) {
                System.out.println(se.getName());
            }
        }

    }
}
