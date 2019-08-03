package com.iadmin.ui.service;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public interface ResourceStorage {

    Stream<InputStream> getResources(String locationPattern) throws IOException;
}
