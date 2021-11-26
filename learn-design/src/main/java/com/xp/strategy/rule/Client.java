package com.xp.strategy.rule;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author zhaoxiaoping
 * @Description: 客户端
 * @Date 2021-1-5
 **/
public class Client {

  public static void main(String[] args) throws UnsupportedEncodingException {

    String str = "3.一根铁丝,用去它的<img type=\"simple\" format=\"latex\" data=\"\\frac {3} {4}\" width=\"7.8\" height=\"\" src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAA6CAYAAABrlNNpAAADA0lEQVRIS+2WTUhUURTH/+e+ZsYKlGjMgkCwTRBBIbmpaCAbMcrwzbsEQeBCiqAPIoQWtZIWfdHHImoTQkXle88njukiLFtVC8tF0CcPFy5MISwGc3TeO3FlZhhLZyZxYdDdvXfv7517/vf873mEBQxaAIP/UFq1rBANDQ0VoVComZljRFSVnh9g5muWZfUA8DNKz0DRaHRlWVlZO4C9AL4DGAGwFkBZeuEN13VbBgYGptVzFiotLT1LRA9N03wPgNWcrusRTdPuA6gAIE3TdLJQngMmKeVFAC3MfNuyrGPFQIjFYieFEDf+CjIM4xwRtfq+f8q27ZsFI+m6vk3TtE4AP6enp2s7OzuHZkGRSGRZOByuYebVQohNAHYC2MPMb5j5sG3bn2dJPofsmfnnAO5MTk7G4/H4xB+QklhKuSqZTAaCweAGZt4ohDgKoAbAx1QqZTiO865gTgCElPIEgKsAXiQSicbe3t4fBf0kpVSV0cfMFURUa5rmYEEop8TqmLnOsqy+gpCu65VCiGdEFPB9f7dScQYyDCPqed6Q4zifcksqEomUhMPhS0Sk8no8NjbW1N/fPzkDpUvlCoCXAHoBfGHm7QAaiagSwKDnefs7OjqGs+pJKXcAuAVgc24kZp4gorupVKrVcZzRuc4J9fX1pYFAYLmaDIVCvuu64xkP5X6soBBz2WapQ1JKdR8UPZh5eKnnVHQyOQsXPycp5RYATQC+JRKJ68q1ee2ubFFeXt4G4CAzf5iamop0dXV9zQsZhnGAiB4BKCkK0nV9naZp3eoOTHeOkUKRyDCMC0R0mpmVY8+oLeWFpJS7mLmHiNo9zzsvhHiaF8psC0BY9bpkMjkeDAb754Wqq6sDVVVVlwEcB9Bsmmabaql5IcMwpOqEAO65rntE2TwvFIvFtgohugGM5t4680K6rq/XNC0OYI3v+/ts236bKbN5ISnlAwCHALwC8Pq3K2yFatDpdyYRTTBzXLWXJ+lfgaIKXrXRvFVeUL25wixxaD5lFt/u/2ikX0eMj88Jb6tEAAAAAElFTkSuQmCC\">,还剩8米,这根铁丝长(  )<br>A.2米<br>B.6米<br>C.32米<br>D.16米";
    System.out.println(str.length());
    System.out.println(URLEncoder.encode(str, "UTF-8").length());
    
    
    String opr = "SUB";
    int a = 2, b = 3;
    OprEnum match = OprEnum.match(opr).orElse(OprEnum.ADD);
    BaseCalcRule rule = match.rule;
    System.out.println(rule.calc(a, b));
  }
}
