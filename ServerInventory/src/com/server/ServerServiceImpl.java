package com.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ServerServiceImpl {

	/**
	 * BiConsumer to Set Data from String to Servers
	 */
	BiConsumer<String, Set<Server>> setServersData = (line, servers) -> {
		List<String> pojoData = Arrays.asList(line.split(","));

		Server server = new Server();
		server.setServerName(pojoData.get(0).trim());
		server.setTechnologyDomain(pojoData.get(1).trim());
		server.setTechnology(pojoData.get(2).trim());
		server.setVersion(pojoData.get(3).trim());
		servers.add(server);
	};

	/**
	 * Read Servers Data From The InventoryFile
	 * 
	 * @param fileName
	 * @return Set<Server>servers
	 * @throws IOException
	 */
	public Set<Server> readFile(String fileName) throws IOException {

		Set<Server> servers = new HashSet<Server>();

		Stream<String> stream = Files.lines(Paths.get(fileName));
		stream.forEach(line -> setServersData.accept(line, servers));

		stream.close();
		return servers;
	}

	/**
	 * Comparator to Compare Servers based on Version
	 */
	Comparator<Server> versionComparator = (a, b) -> {
		return versionToCompaparableVersion(a).compareTo(
				versionToCompaparableVersion(b));
	};

	/**
	 * BiConsumer to Calculate Outdated Servers From Stream of TechnologyWise
	 * Servers
	 */
	BiConsumer<Entry<String, Set<Server>>, Set<Server>> getOutdatedServers = (
			entrySet, outdatedServers) -> {

		Set<Server> serversTechWise = entrySet.getValue();

		int lastServerVersion = versionToCompaparableVersion(serversTechWise
				.stream().max(versionComparator).get());

		outdatedServers
				.addAll(serversTechWise
						.stream()
						.filter(s -> versionToCompaparableVersion(s) < lastServerVersion)
						.collect(Collectors.toList()));
	};

	/**
	 * Returns Outdated Servers Set from All Server Set
	 * 
	 * @param Set
	 *            <Server> servers
	 * @return Set<Server> outdatedServers
	 */
	public Set<Server> getOutdatedServers(Set<Server> servers) {

		Set<Server> outdatedServers = new HashSet<Server>();

		Map<String, Set<Server>> technologyWiseServers = 
				servers.stream()
				.collect(Collectors.groupingBy(Server::getTechnology,Collectors.toSet()));

		technologyWiseServers.entrySet().forEach(
				es -> getOutdatedServers.accept(es, outdatedServers));

		return outdatedServers;

	}

	/**
	 * Write Outdated Server names into ServerOutputInvertory File
	 * 
	 * @param outdatedServers
	 * @param outPutFile
	 * @return Boolean
	 * @throws IOException
	 */
	public Boolean writeOutdatedServers(Set<Server> outdatedServers,
			String outPutFile) throws IOException {

		String outdatedServerNames = outdatedServers.stream()
				.map(Server::getServerName).collect(Collectors.joining(","));

		Files.write(Paths.get(outPutFile), outdatedServerNames.getBytes());
		return true; // if no exception then only code reach here
	}

	/**
	 * Convert Servers version from String to Integer.
	 * 
	 * @param serverTechWise
	 * @return Integer
	 */
	private Integer versionToCompaparableVersion(Server serverTechWise) {
		String version;
		version = serverTechWise.getVersion().replaceAll("\\.", "");
		return Integer.parseInt(version);
	}

	/**
	 * Server Pojo
	 *
	 */
	class Server {

		private String serverName;
		private String technologyDomain;
		private String technology;
		private String version;

		public Server() {
		}

		public Server(String serverName, String technologyDomain,
				String technology, String version) {
			this.serverName = serverName;
			this.technologyDomain = technologyDomain;
			this.technology = technology;
			this.version = version;
		}

		public String getServerName() {
			return serverName;
		}

		public void setServerName(String serverName) {
			this.serverName = serverName;
		}

		public String getTechnologyDomain() {
			return technologyDomain;
		}

		public void setTechnologyDomain(String technologyDomain) {
			this.technologyDomain = technologyDomain;
		}

		public String getTechnology() {
			return technology;
		}

		public void setTechnology(String technology) {
			this.technology = technology;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}

		@Override
		public String toString() {
			return "\n Server [serverName=" + serverName
					+ ", technologyDomain=" + technologyDomain
					+ ", technology=" + technology + ", version=" + version
					+ "] \n";
		}

	}

}
