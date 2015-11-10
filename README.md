# CMSC330

## LEXICAL PARSING

import java.util.regex.*

def p = [
  number    : Pattern.compile("[1-9][0-9]*"),
  period    : Pattern.compile(".", Pattern.LITERAL),
  string    : Pattern.compile("\"([^\"]*)\""),
  eol       : Pattern.compile("\n"),
  blank     : Pattern.compile("[ \t]*")
  ]

def string = """
"This is a string"

        555.123.4444

12 34   45 9999    
"""

def matcher = p.number.matcher(string)
def found
def lineNumber = 1
def offset = 1
while (string) {
  if (Thread.interrupted()) break;
  def patternUsed = false
  p.each { k,v ->
    matcher.usePattern(v)
    found = matcher.lookingAt()
    patternUsed |= found
    if (found) {
      string = string.substring(matcher.end())
      if (k == "eol") {
        lineNumber++
        offset = 1
      }
      if (matcher.end-matcher.start()) {
        if (!(k in ["eol","blank"])) {
          println "$k : [${matcher.group(matcher.groupCount())}] at [$lineNumber:$offset]"
        }
        offset += matcher.group().length()
        matcher.reset(string)
      }
    }
  }
  if (!patternUsed) throw new Exception("Syntax error at [$lineNumber:$offset]")
}
