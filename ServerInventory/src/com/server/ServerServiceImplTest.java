package com.server;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.server.ServerServiceImpl.Server;

public class ServerServiceImplTest {
	ServerServiceImpl serverService;

	@Before
	public void setup() {
		serverService = new ServerServiceImpl();
	}

	@Test(expected = IOException.class)
	public void readFile_FileNotFound_Test() throws IOException {
		String fileName = "";
		serverService.readFile(fileName);
	}

	@Test
	public void readFile_FileFound_Test() throws IOException {
		String fileName = "C://Users//Administrator//Desktop//IdeasServerInventory//Copy of ServerInventory//resources//serverInventory.txt";
		int serverCount = serverService.readFile(fileName).size();
		Assert.assertTrue("all server expected count is 6", serverCount == 6);
	}

	@Test
	public void outdatedServers_Test() throws IOException {
		String fileName = "C://Users//Administrator//Desktop//IdeasServerInventory//Copy of ServerInventory//resources//serverInventory.txt";
		Set<Server> servers = serverService.readFile(fileName);
		int outdatedServerCount = serverService.getOutdatedServers(servers)
				.size();
		Assert.assertTrue("Outdated Server expected count is 2 ",
				outdatedServerCount == 2);
	}

	@Test(expected = IOException.class)
	public void writeOutdatedServers_FileNotFound_Test() throws IOException {
		Set<Server> outdatedServers = getOutdatedServerList();
		String outPutFileName = "";
		serverService.writeOutdatedServers(outdatedServers, outPutFileName);
	}

	@Test
	public void writeOutdatedServers_FileFound_Test() throws IOException {
		Set<Server> outdatedServers = getOutdatedServerList();
		String outPutFileName = "C://Users//Administrator//Desktop//IdeasServerInventory//Copy of ServerInventory//resources//serverOutpuInventory.txt";
		Assert.assertTrue("checking if Outdated Servers written into file",
				serverService.writeOutdatedServers(outdatedServers,
						outPutFileName));
	}

	private Set<Server> getOutdatedServerList() throws IOException {
		String fileName = "C://Users//Administrator//Desktop//IdeasServerInventory//Copy of ServerInventory//resources//serverInventory.txt";
		Set<Server> servers = serverService.readFile(fileName);
		Set<Server> outdatedServers = serverService
				.getOutdatedServers(servers);
		return outdatedServers;
	}

}
