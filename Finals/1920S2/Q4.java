class FileIOException extends Exception { }
class FileNotFoundException extends FileIOException { }
class FileMetadataException extends FileIOException { }
class IncorrectPermissionException extends FileMetadataException { }
class IncorrectSizeException extends FileMetadataException { }

class DatabaseException extends Exception { }
class TableException extends DatabaseException { }
class ReadException extends TableException { }
class ElementNotFoundException extends ReadException { }
class WriteException extends TableException { }
class NoPermissionException extends WriteException { }

class InternetException extends Exception { }
class ConnectionFailureException extends InternetException { }
class AuthenticationException extends ConnectionFailureException { }
class LoginFailureException extends AuthenticationException { }
class NoSuchUsernameException extends LoginFailureException { }
class PasswordIncorrectException extends LoginFailureException { }