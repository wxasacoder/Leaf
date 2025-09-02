package com.sankuai.inf.leaf;

import com.sankuai.inf.leaf.common.IdResult;

public interface IDGen {
    IdResult get(String key);
    boolean init();
}
